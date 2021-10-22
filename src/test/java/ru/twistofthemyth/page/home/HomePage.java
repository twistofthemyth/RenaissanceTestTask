package ru.twistofthemyth.page.home;

import ru.twistofthemyth.annotation.Page;
import ru.twistofthemyth.page.PageBase;
import ru.twistofthemyth.page.home.navbar.NavBar;
import ru.twistofthemyth.service.DriverHolder;

public class HomePage extends PageBase {

    public HomePage(DriverHolder driver) {
        super(driver);
    }

    @Page
    public NavBar navBar;

    //other pages and elements
}
