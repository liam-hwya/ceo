package com.sdm.hr.controller;

import com.sdm.Constants;
import com.sdm.hr.model.Payment;
import com.sdm.hr.model.Staff;
import com.sdm.hr.model.WorkingHour;
import com.sdm.hr.repository.PaymentRepository;
import com.sdm.hr.repository.WorkingHourRepository;
import com.sdm.master.entity.FileEntity;
import com.sdm.master.entity.UserEntity;
import com.sdm.master.repository.UserRepository;
import com.sdm.master.service.FileService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class StaffController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkingHourRepository workingHourRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private FileService fileService;

    private static List<WorkingHour> workingHours = new ArrayList<WorkingHour>();

    @GetMapping("/staff/")
    public String getStaff(
           @RequestParam(defaultValue = "0" )int page ,
           @RequestParam(defaultValue = "displayName")String sort,
           @RequestParam(defaultValue = "ASC")String order,
            Model model){

        switch (order){
            case "ASC": model.addAttribute("data",userRepository.findAll(PageRequest.of(page,4, Sort.by(Sort.Direction.ASC,sort))));
                break;

            case "DESC": model.addAttribute("data",userRepository.findAll(PageRequest.of(page,4,Sort.by(Sort.Direction.DESC,sort))));
                break;
        }

        model.addAttribute("sort",sort);
        model.addAttribute("order",order);

        return "/User/index";
    }

    @GetMapping("/staff/add/")
    public String insertStaff(Model model){

        Staff staff = new Staff();

        model.addAttribute("staff",staff);
        model.addAttribute("dayOfWeeks", Constants.DAY_OF_WEEK);
        model.addAttribute("staffLists",userRepository.findAll());

        return "/User/insert";
    }

    @Transactional
    @PostMapping("/staff/add/{id}")
    public String save(
            @RequestParam("file") MultipartFile file,
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "isPublic", defaultValue = "true") boolean isPublic,
            @Valid Staff staff,
            RedirectAttributes redirAttrs,
            BindingResult result){

//        if (result.hasErrors()) {
//            return "User/insert";
//        }

        UserEntity user=staff.getUser();

        FileEntity newFile = fileService.create(file, isPublic); // data import to file tables;
        user.setProfileImage(newFile);

        if(id==0){

            if(!user.getPassword().equals(user.getConfirmPassword())){

                redirAttrs.addFlashAttribute("message", "Password do not match");
                return "redirect:/staff/add/0";
            }
        }else{
            user.setId(id);

            UserEntity userEntity=userRepository.findById(id).orElse(new UserEntity());

            String pw = userEntity.getPassword();

            user.setPassword(pw);
        }

        user.setStatus(UserEntity.Status.ACTIVE);

        userRepository.save(user);

        Payment payment = staff.getPayment();

        id=user.getId();

        if(id!=0){
            payment.setId(id);
        }

        payment.setUserId(id);

        paymentRepository.save(payment);

        if(id!=0){
            workingHourRepository.deleteByUserId(id);
        }

        for(WorkingHour workingHour:staff.getWorkingHours()) {

            if (workingHour.getCheckedDay() != null) {

                if (workingHour.getCheckedDay()) {

                    workingHour.setUserId(user.getId());

//                    if(id!=0){
//                        workingHour.setUserId(id);
//                    }

                    workingHourRepository.save(workingHour);
                }
            }
        }
        return "redirect:/staff/";
    }


    @GetMapping("/staff/add/{id}")
    public String detail(
            @PathVariable("id") Long id,
            Model model){

        Staff staff = new Staff();

        UserEntity user = userRepository.findById(id).orElse(new UserEntity());
        List<WorkingHour> workingHours = workingHourRepository.findByUserId(id);
        Payment payment = paymentRepository.findByUserIdForPayment(id);
        staff.setPayment(payment);
        staff.setUser(user);

        List<WorkingHour> dowArrays = new ArrayList<>();

        for(int i=0;i<6;i++){
            WorkingHour wh = new WorkingHour();
            wh.setDayOfWeek(i);

            wh.setCheckedDay(false);
//            wh.setCheckedDay(!(i==0 || i==6));


            for(WorkingHour staffWh:workingHours){
                if(staffWh.getDayOfWeek()==i){
                    wh = staffWh;
                    wh.setCheckedDay(true);
                    break;
                }
            }

            dowArrays.add(wh);
        }

        staff.setWorkingHours(dowArrays);

        model.addAttribute("dayOfWeeks", Constants.DAY_OF_WEEK);
        model.addAttribute("data", staff);
        model.addAttribute("paymentData",paymentRepository.findByUserIdForPayment(id));
        model.addAttribute("staffLists",userRepository.findAll());

        return "/User/insert";
    }

    @GetMapping("/staff/assign/")
    public String assign(@RequestParam Long id,Model model){

        model.addAttribute("data",userRepository.findById(id).orElse(new UserEntity()));

        return "/User/assign";
    }



    @GetMapping("/staff/payment/")
    public String payment(@RequestParam Long id,Model model){

        model.addAttribute("data",userRepository.findById(id).orElse(new UserEntity()));

        return "/User/payment";
    }

    @PostMapping("/staff/payment/")
    public String payment(@Valid Payment payment){

        paymentRepository.save(payment);

        return "redirect:/staff/";

    }

}
