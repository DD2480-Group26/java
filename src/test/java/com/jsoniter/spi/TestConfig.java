package com.jsoniter.spi;

import com.jsoniter.TestAnnotationJsonCreator.TestObject;
import com.jsoniter.output.EncodingMode;
import com.jsoniter.output.TestAnnotationJsonIgnore.TestPrivateVariables;

import org.junit.Before;
import org.junit.Test;

/**
 * Test missing branches for updateBindings in Config
 */
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
    public void TestUpdateBindingsBranch21() {
        ClassDescriptor desc = ClassDescriptor.getEncodingClassDescriptor(new ClassInfo(TestPrivateVariables.class), true);
        desc.getters.get(0).name = "test";
        cfg.updateClassDescriptor(desc);
    }

    @Test
    public void TestUpdateBindingsBranch22() {
        ClassDescriptor desc = ClassDescriptor.getDecodingClassDescriptor(new ClassInfo(TestObject.class), true);
        desc.getters = null;
        cfg.updateClassDescriptor(desc);
    }
}
