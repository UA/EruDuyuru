package com.ua.eruduyuru.ui.main;

import com.ua.eruduyuru.data.helper.htmlParser.model.Department;
import com.ua.eruduyuru.ui.base.BaseView;

import java.util.List;

public interface MainView extends BaseView {
    void onRetrieveDepartments(List<Department> result);
}
