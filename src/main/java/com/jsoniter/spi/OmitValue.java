package com.jsoniter.spi;

import com.jsoniter.group26logger.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Arrays;

public interface OmitValue {

    boolean shouldOmit(Object val);

    String code();

    class Null implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return val == null;
        }

        @Override
        public String code() {
            return "null == %s";
        }
    }

    class ZeroByte implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return (Byte) val == 0;
        }

        @Override
        public String code() {
            return "0 == %s";
        }
    }

    class ZeroShort implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return (Short) val == 0;
        }

        @Override
        public String code() {
            return "0 == %s";
        }
    }

    class ZeroInt implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return ((Integer) val) == 0;
        }

        @Override
        public String code() {
            return "0 == %s";
        }
    }

    class ZeroLong implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return ((Long) val) == 0;
        }

        @Override
        public String code() {
            return "0 == %s";
        }
    }

    class ZeroFloat implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return ((Float) val) == 0;
        }

        @Override
        public String code() {
            return "0 == %s";
        }
    }

    class ZeroDouble implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return ((Double) val) == 0;
        }

        @Override
        public String code() {
            return "0 == %s";
        }
    }

    class ZeroChar implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return (Character) val == 0;
        }

        @Override
        public String code() {
            return "0 == %s";
        }
    }

    class False implements OmitValue {

        @Override
        public boolean shouldOmit(Object val) {
            return !((Boolean) val);
        }

        @Override
        public String code() {
            return "false == %s";
        }
    }


    class Parsed implements OmitValue {

        private final Object defaultValue;
        private final String code;

        public Parsed(Object defaultValue, String code) {
            this.defaultValue = defaultValue;
            this.code = code;
        }

        // if not already written, writes to `fileName` that branch `branchId` has been covered.
        private static void branchCovered(int branchId, String fileName) {
            try {
                String line = "Branch " + branchId + " covered";
                FileWriter logWriter = new FileWriter(fileName, true);
                BufferedWriter bw = new BufferedWriter(logWriter);
                if(!FileMethods.fileContains(fileName, line)) {
                    bw.write(line);
                    bw.newLine();
                    bw.close();
                }
            }
            catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }

        public static OmitValue parse(Type valueType, String defaultValueToOmit) {
            if ("void".equals(defaultValueToOmit)) {
                branchCovered(1, "createDecoderBranchCoverage.txt");
                return null;
            } else if ("null".equals(defaultValueToOmit)) {
                branchCovered(2, "createDecoderBranchCoverage.txt");
                return new OmitValue.Null();
            } else if (boolean.class.equals(valueType)) {
                branchCovered(3, "createDecoderBranchCoverage.txt");
                Boolean defaultValue = Boolean.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == %s");
            } else if (Boolean.class.equals(valueType)) {
                branchCovered(4, "createDecoderBranchCoverage.txt");
                Boolean defaultValue = Boolean.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == %s.booleanValue()");
            } else if (int.class.equals(valueType)) {
                branchCovered(5, "createDecoderBranchCoverage.txt");
                Integer defaultValue = Integer.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == %s");
            } else if (Integer.class.equals(valueType)) {
                branchCovered(6, "createDecoderBranchCoverage.txt");
                Integer defaultValue = Integer.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == %s.intValue()");
            } else if (byte.class.equals(valueType)) {
                branchCovered(7, "createDecoderBranchCoverage.txt");
                Byte defaultValue = Byte.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == %s");
            } else if (Byte.class.equals(valueType)) {
                branchCovered(8, "createDecoderBranchCoverage.txt");
                Byte defaultValue = Byte.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == %s.byteValue()");
            } else if (short.class.equals(valueType)) {
                branchCovered(9, "createDecoderBranchCoverage.txt");
                Short defaultValue = Short.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == %s");
            } else if (Short.class.equals(valueType)) {
                branchCovered(10, "createDecoderBranchCoverage.txt");
                Short defaultValue = Short.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + " == %s.shortValue()");
            } else if (long.class.equals(valueType)) {
                branchCovered(11, "createDecoderBranchCoverage.txt");
                Long defaultValue = Long.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "L == %s");
            } else if (Long.class.equals(valueType)) {
                branchCovered(12, "createDecoderBranchCoverage.txt");
                Long defaultValue = Long.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "L == %s.longValue()");
            } else if (float.class.equals(valueType)) {
                branchCovered(13, "createDecoderBranchCoverage.txt");
                Float defaultValue = Float.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "F == %s");
            } else if (Float.class.equals(valueType)) {
                branchCovered(14, "createDecoderBranchCoverage.txt");
                Float defaultValue = Float.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "F == %s.floatValue()");
            } else if (double.class.equals(valueType)) {
                branchCovered(15, "createDecoderBranchCoverage.txt");
                Double defaultValue = Double.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "D == %s");
            } else if (Double.class.equals(valueType)) {
                branchCovered(16, "createDecoderBranchCoverage.txt");
                Double defaultValue = Double.valueOf(defaultValueToOmit);
                return new OmitValue.Parsed(defaultValue, defaultValueToOmit + "D == %s.doubleValue()");
            } else if (char.class.equals(valueType) && defaultValueToOmit.length() == 1) {
                branchCovered(17, "createDecoderBranchCoverage.txt");
                Character defaultValue = defaultValueToOmit.charAt(0);
                return new OmitValue.Parsed(defaultValue, "'" + defaultValueToOmit + "' == %s");
            } else if (Character.class.equals(valueType) && defaultValueToOmit.length() == 1) {
                branchCovered(18, "createDecoderBranchCoverage.txt");
                Character defaultValue = defaultValueToOmit.charAt(0);
                return new OmitValue.Parsed(defaultValue, "'" + defaultValueToOmit + "' == %s.charValue()");
            } else {
                branchCovered(19, "createDecoderBranchCoverage.txt");
                throw new UnsupportedOperationException("failed to parse defaultValueToOmit: " + defaultValueToOmit);
            }
        }

        @Override
        public boolean shouldOmit(Object val) {
            return defaultValue.equals(val);
        }

        @Override
        public String code() {
            return code;
        }
    }
}
