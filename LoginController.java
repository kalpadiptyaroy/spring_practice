package springwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;;

@Controller
public class LoginController 
{
    @Autowired
    private LoginValidator validator;
    

	@InitBinder
	protected void initBinder(WebDataBinder binder) 
	{
		binder.addValidators(validator);
	}
    
    @RequestMapping(value="/index.do", method=RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView mv = new ModelAndView("Login");
        return mv;
    }
    
    @PostMapping(value="/loginProcess.do")
    public ModelAndView loginProcess(@ModelAttribute("user") @Validated User user,BindingResult result)
    {
         ModelAndView mv = new ModelAndView();   
        
         if(result.hasErrors())
         {
        	 mv.setViewName("Login");
         }
         else
        	 mv.setViewName("Home");
         return mv;
    }
}
