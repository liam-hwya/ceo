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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

//    @GetMapping("/staff/add/")
//    public String insertStaff(
//            @PathVariable("id") Long id,
//            Model model
//    ){
//
//        Staff staff = new Staff();
//
//        model.addAttribute("staff",staff);
//        model.addAttribute("dayOfWeeks", Constants.DAY_OF_WEEK);
//        model.addAttribute("staffLists",userRepository.findAll());
//
//        return "/User/insert";
//    }

    @Transactional
    @PostMapping("/staff/add/{id}")
    public String save(
            @PathVariable(value = "id") Long id,
            @Valid Staff staff,
            BindingResult bindingResult,
            @RequestParam(value = "isPublic", defaultValue = "true") boolean isPublic,
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirAttrs,
            Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("dayOfWeeks", Constants.DAY_OF_WEEK);
            model.addAttribute("staffLists",userRepository.findAll());
            return "User/insert";
        }

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
        model.addAttribute("staff", staff);
        model.addAttribute("paymentData",paymentRepository.findByUserIdForPayment(id));
        model.addAttribute("staffLists",userRepository.findAll());

        return "/User/insert";
    }
}
