package com.rest.demo.api;

import com.rest.demo.model.DemoModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoApi {

    @RequestMapping(method = RequestMethod.GET, value = "/getDemo")
    public List<DemoModel> getDemo() {
        return generate();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public DemoModel delete(@PathVariable int id) {
        List<DemoModel> generate = generate();
        DemoModel demoModel = null;
        for (DemoModel model : generate) {
            if (model.getId() == id) {
                demoModel=model;
                generate.remove(demoModel);
            }
        }
        return demoModel;
    }

    @NotNull
    private List<DemoModel> generate() {
        ArrayList<DemoModel> demo = new ArrayList<>();
        DemoModel demoModel = new DemoModel();
        for(int i=1; i<3; i++) {
            demoModel.setName("test"+i);
            demoModel.setId(i+1000);
            demo.add(demoModel);
        }
        return demo;
    }
}
