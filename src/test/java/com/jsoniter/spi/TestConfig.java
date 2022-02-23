package com.jsoniter.spi;

import java.util.ArrayList;
import java.util.List;

import com.jsoniter.TestAnnotationJsonCreator.TestObject;
import com.jsoniter.TestGenerics.Class3;
import com.jsoniter.output.EncodingMode;

import org.junit.Before;
import org.junit.Test;

public class TestConfig {
    Config cfg;

    @Before
    public void CreateVariables() {
        cfg = new Config.Builder()
                .encodingMode(EncodingMode.REFLECTION_MODE)
                .indentionStep(2)
                .build();

    }

    @Test
    public void TestUpdateBindingsBranch1() {
        ClassDescriptor desc = ClassDescriptor.getDecodingClassDescriptor(new ClassInfo(Class3.class), true);
        desc.fields = new ArrayList<Binding>();
        desc.setters = null;
        desc.getters = null;
        desc.ctor = null;
        desc.bindingTypeWrappers = null;
        cfg.updateClassDescriptor(desc);
    }

    @Test
    public void TestUpdateBindingsBranch22() {
        ClassDescriptor desc = ClassDescriptor.getDecodingClassDescriptor(new ClassInfo(TestObject.class), true);
        desc.getters = null;
        cfg.updateClassDescriptor(desc);
    }


    public static void main(String[] args) {
        TestConfig tc = new TestConfig();
        tc.TestUpdateBindingsBranch22();
    }
}
