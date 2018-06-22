package com.example.daniyar.hr_crm.ui;

public interface LifeCycle<V> {

    void bind(V view);

    void unbind();
}
