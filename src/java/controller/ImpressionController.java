/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Impression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Emin
 */
@Controller
public class ImpressionController {
    
    @RequestMapping (value = "/impression", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {
        
        model.addAttribute("impression", new Impression());
        model.addAttribute("impressions", Impression.allImpressions());
        return "impression";
    }
    @RequestMapping (value = "/impression", method = RequestMethod.POST)
    public String addImpression(@ModelAttribute("impression") Impression impression, ModelMap model) throws ClassNotFoundException {
        
        impression.insertImpression();;
        createForm(model);
        return "impression";
    }
    
}
