package com.cds.typeperfectapp.start;

import com.cds.typeperfectapp.controller.*;
import com.cds.typeperfectapp.views.*;

public class main {
    public static void main(String[] args) {
        ViewStart view = new ViewStart();
        ControllerViewStart controller = new ControllerViewStart(view);
    }
}
