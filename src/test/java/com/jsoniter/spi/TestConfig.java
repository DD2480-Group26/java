package com.jsoniter.spi;

import com.jsoniter.TestAnnotationJsonCreator.TestObject;
import com.jsoniter.output.EncodingMode;
import com.jsoniter.output.TestAnnotationJsonIgnore.TestPrivateVariables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test missing branches for updateBindings in Config
 */
public class TestConfig {
    Config cfg;

    @Before
    public void createVariables() {
        cfg = new Config.Builder()
                .encodingMode(EncodingMode.REFLECTION_MODE)
                .indentionStep(2)
                .build();
    }
    
    @Test
    public void testUpdateBindingsBranch21() {
        Exception exp = null;
        try {
            ClassDescriptor desc = ClassDescriptor.getEncodingClassDescriptor(new ClassInfo(TestPrivateVariables.class), true);
            desc.getters.get(0).name = "test";
            cfg.updateClassDescriptor(desc);
        } catch (Exception e) {
            exp = e;
        }
        Assert.assertNull(exp);
    }

    @Test
    public void testUpdateBindingsBranch22() {
        Exception exp = null;
        try {
            ClassDescriptor desc = ClassDescriptor.getDecodingClassDescriptor(new ClassInfo(TestObject.class), true);
            desc.getters = null;
            cfg.updateClassDescriptor(desc);
        } catch (Exception e) {
            exp = e;
        }
        Assert.assertNull(exp);
    }
}
