/*  MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package test.java;

/**
 * RulesOf6005 represents the collaboration policy of 6.005 as described by the
 * general information on Stellar.
 * RulesOf6005表示6.005的协作策略，如*关于Stellar的一般信息所述。
 */
public class RulesOf6005 {

    /**
     * Judge whether a given piece of code may be used in an assignment (problem
     * set or team project) or not, according to the 6.005 collaboration policy.
     * 根据6.005协作策略，判断给定的代码段是否可用于任务（问题集或团队项目）中。
     *
     * @param writtenByYourself      true if the code in question was written by
     *                               yourself or, in the case of a team project, your teammates,
     *                               otherwise false.
     *                               如果所讨论的代码是您自己编写的，或者在团队项目中是您的队友编写的，则为true，否则为false。
     * @param availableToOthers      if not writtenByYourself, whether or not the
     *                               code in question is available to all other students in the class.
     *                               Otherwise ignored.
     *                               如果不是自己写的，则该代码是否可供班上所有其他学生使用，否则将被忽略。
     * @param writtenAsCourseWork    if not writtenByYourself, whether or not the
     *                               code in question was written specifically as part of a solution to
     *                               a 6.005 assignment, in the current or past semesters. Otherwise
     *                               ignored.
     *                               如果不是自己编写的，则是否在当前或过去的学期中将所讨论的代码专门编写为6.005作业解决方案的一部分。否则忽略。
     * @param citingYourSource       if not writtenByYourself, whether or not you
     *                               properly cite your source. Otherwise ignored.
     *                               如果不是您自己写的，则无论您是否正确引用了您的出处。否则忽略。
     * @param implementationRequired whether the assignment specifically asks
     *                               you to implement the feature in question.
     *                               任务是否明确要求您实现相关功能。
     * @return Whether or not, based on the information provided in the
     * arguments, you are likely to be allowed to use the code in
     * question in your assignment, according to the 6.005 collaboration
     * policy for the current semester.
     * 根据当前学期的6.005合作政策，是否有可能根据参数中提供的信息在您的作业中使用代码查询。
     */
    public static boolean mayUseCodeInAssignment(boolean writtenByYourself,
                                                 boolean availableToOthers, boolean writtenAsCourseWork,
                                                 boolean citingYourSource, boolean implementationRequired) {
        /**
         * 判断是否是自己写的代码,如果是自己写的则返回true或者
         * 是允许其他人写的和是表明了引用的
         * 或者是没有在课上写过的，没有布置任务的
         * 都返回true，其余返回false；
         */
        if (writtenByYourself || (!writtenAsCourseWork && !implementationRequired && availableToOthers && citingYourSource)) {
            return true;
        } else {
            return false;
        }
    }

    // TODO: Fill in this method, then remove the exception
    //System.out.println("test");
    //throw new RuntimeException("implement me!");

    /**
     * Main method of the class.
     * <p>
     * Runs the mayUseCodeInAssignment method.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("You may certainly use code you wrote yourself: " +
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
//        RulesOf6005Test test = new RulesOf6005Test();
//        test.testMayUseCodeInAssignment();
    }
}
