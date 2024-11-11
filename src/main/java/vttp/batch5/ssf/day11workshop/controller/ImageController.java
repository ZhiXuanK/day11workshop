package vttp.batch5.ssf.day11workshop.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/", "/index.html"})
public class ImageController {
    
    //can look at chuk's code on github

    @GetMapping()
    public String getImage(Model model){
        File[] images = (new File("src/main/resources/static/images")).listFiles();
        //String[] images = (new File("/Users/zhixuan/Desktop/NUS-ISS/SSFDailyCodes/day11workshop/src/main/resources/static/images")).list();
        Random rnd = new Random();
        //int index = rnd.nextInt(images.length);
        File file = images[rnd.nextInt(images.length)];
        //String currImg = images[rnd.nextInt(images.length)];
        Path base = Paths.get("src/main/resources/static"); //
        Path img = file.toPath();
        Path relative = base.relativize(img);
        //String path = currImg.substring(currImg.indexOf("static")+6);
        model.addAttribute("currImg", relative); //variable/attribute within the page, we call the key in the html file to access the value
        return "image"; //return the html file inside templates
    }
}
