package com.cqgs.app.business.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by fuda on 15/8/11.
 */
public class TestForm {

    @NotNull(message = "名称不能为空")
    private String name;

    @Min(value = 0,message = "年龄必须大于0")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
