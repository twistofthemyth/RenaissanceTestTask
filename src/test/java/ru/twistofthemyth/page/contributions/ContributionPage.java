package ru.twistofthemyth.page.contributions;

import org.jetbrains.annotations.NotNull;
import ru.twistofthemyth.annotation.Page;
import ru.twistofthemyth.page.PageBase;
import ru.twistofthemyth.service.DriverHolder;

public class ContributionPage extends PageBase {
    public ContributionPage(@NotNull DriverHolder driver) {
        super(driver);
    }

    @Page
    public Calculator calculator;
}
