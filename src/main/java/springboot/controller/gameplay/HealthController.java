package springboot.controller.gameplay;

import springboot.view.HealthView;

public class HealthController {
    private HealthView view;

    public HealthController(HealthView view) {
        this.view = view;
    }

}
