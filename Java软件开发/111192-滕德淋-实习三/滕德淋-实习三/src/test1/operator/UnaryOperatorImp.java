package test1.operator;

/**
 * Enum that contains implements of UnaryOperator
 *
 * @author zhilinh
 */
public enum UnaryOperatorImp implements UnaryOperator {
    ABS {
        /**
         * toString method that returns the abs operator "abs".
         */
        @Override
        public String toString() {
            return "abs";
        }

        /**
         * Method that returns the absolute value of arg.
         *
         * @param arg as the value.
         * @return the absolute value.
         */
        public double apply(double arg) {
            return Math.abs(arg);
            //throw new Exception("Need to be implemented！");
        }
    },
    NEGATION {
        /**
         * toString method that returns the negation operator "��".
         */
        @Override
        public String toString() {
            return "neg";
        }

        /**
         * Method that returns the value of arg with a contrary sign.
         *
         * @param arg as the value.
         * @return the negated value.
         */
        public double apply(double arg) {
            //throw new Exception("Need to be implemented！");
            return -arg;
        }
    },
    SIN{
        @Override
        public String toString(){return "sin";}
        public double apply(double arg) {
            //throw new Exception("Need to be implemented！");
            return Math.sin( Math.toRadians(arg));
        }
    },
    COS{
        @Override
        public String toString(){return "cos";}
        public double apply(double arg) {
            //throw new Exception("Need to be implemented！");
            return Math.cos(Math.toRadians(arg));
        }
    },
    TAN{
        @Override
        public String toString(){return "tan";}
        public double apply(double arg) {
            //throw new Exception("Need to be implemented！");
            return Math.tan(Math.toRadians(arg));
        }
    },
    LOG{
        @Override
        public String toString(){return "log";}
        public double apply(double arg) {
            //throw new Exception("Need to be implemented！");
            return Math.log(arg);
        }
    }


}