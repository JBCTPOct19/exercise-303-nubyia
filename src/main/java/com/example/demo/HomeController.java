package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String listCar(Model model){
        model.addAttribute("cars", carRepository.findAll());
        return "list";

    }

    @GetMapping("/add")
    public String todoform(Model model){
        model.addAttribute("cars", new Cars());
        return "carform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Cars cars,
                              BindingResult result){
        if (result.hasErrors()){
            return "carform";
        }
        carRepository.save(cars);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCars(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("cars", carRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateCars(@PathVariable("id") long id,
                             Model model) {
        model.addAttribute("cars", carRepository.findById(id).get());
        return "carform";
    }
    @RequestMapping("/delete/{id}")
    public String delCars(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "redirect:/";

    }
}
