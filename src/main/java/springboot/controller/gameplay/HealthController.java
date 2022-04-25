package springboot.controller.gameplay;

import springboot.view.HealthBarView;

public class HealthController {
    private HealthBarView view;

    public HealthController(HealthBarView view) {
        this.view = view;
    }

}
