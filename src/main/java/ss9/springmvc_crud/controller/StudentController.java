package ss9.springmvc_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ss9.springmvc_crud.model.Student;
import ss9.springmvc_crud.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public ModelAndView getAllStudent() {
        ModelAndView mav = new ModelAndView("students");
        List<Student> listStudent = studentService.findAll();
        mav.addObject("listStudent", listStudent);
        return mav;
    }

    @GetMapping("/initCreate")
    public ModelAndView initCreateStudent() {
        ModelAndView mav = new ModelAndView("newStudent");
        Student studentNew = new Student();
        mav.addObject("studentNew", studentNew);
        return mav;
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("newStudent") Student student) {
        boolean result = studentService.create(student);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
//    @GetMapping("/edit") // lấy ra thông tin cần sửa
//    public  String edit(@RequestParam Integer id, Model){
//        model.addAttribute("student",studentService.findById(id));
//        return "views/edit";
//    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam Integer id){
        ModelAndView mav = new ModelAndView("/edit");
        mav.addObject("students",studentService.findById(id));
        return mav;
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Student student){
        studentService.update(student);
        return "redirect:/studentController/findAll";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        studentService.deleteById(id);
        return "redirect:/studentController/findAll";
    }
}
