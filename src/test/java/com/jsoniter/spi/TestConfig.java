package com.jsoniter.spi;

import com.jsoniter.TestGenerics.Class3;
import com.jsoniter.output.EncodingMode;

import org.junit.Test;

public class TestConfig {
    // @Test
    public void TestUpdateBindings() {
        Config cfg = new Config.Builder()
                .encodingMode(EncodingMode.REFLECTION_MODE)
                .indentionStep(2)
                .build();

        // updateClassDescriptor
        ClassDescriptor desc = ClassDescriptor.getDecodingClassDescriptor(new ClassInfo(Class3.class), true);
        cfg.updateClassDescriptor(desc);
    }

    public static void main(String[] args) {
        TestConfig tc = new TestConfig();
        tc.TestUpdateBindings();

    }
}
