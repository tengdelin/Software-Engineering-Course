import {expect} from 'chai'
import {mount} from '@vue/test-utils'
import sw_1 from '@/views/1-sw'

describe('测试行李计算器软件', () => {
    describe('1、UI练习测试', function () {
        it('初始值测试isShow1', () => {
            const wrapper = mount(sw_1);
            expect(wrapper.vm.isShow1).to.be.not.ok
        });
        it('初始值测试isShow2', () => {
            const wrapper = mount(sw_1);
            expect(wrapper.vm.isShow2).to.be.not.ok
        });
        it('初始值测试isbaby', () => {
            const wrapper = mount(sw_1);
            expect(wrapper.vm.isbaby).to.be.not.ok
        });
        it('初始值测试show1', () => {
            const wrapper = mount(sw_1);
            expect(wrapper.vm.show1).to.be.not.ok
        });
        it('初始值测试dialogVisible', () => {
            const wrapper = mount(sw_1);
            expect(wrapper.vm.dialogVisible).to.be.not.ok
        });
        it('初始值测试result', () => {
            const wrapper = mount(sw_1);
            expect(wrapper.vm.result).to.be.equal(0)
        });
        it('初始值测试点击国内航班', () => {
            const wrapper = mount(sw_1);
            let elementDOMWrapper = wrapper.find("[label='国内航班']");
            elementDOMWrapper.trigger("click")
            expect(wrapper.vm.isShow1).to.be.ok
        });
    });
    describe('2、行李托运测试', function () {
        it('国内航班-1', () => {
            const wrapper = mount(sw_1);
            wrapper.find("[label='国内航班']")
            let elementDOMWrapper = wrapper.find("[label='旅客类型']");
            elementDOMWrapper.trigger("click")
            let elementDOMWrapper1 = wrapper.find("[label='成人']");
            elementDOMWrapper1.trigger("click")
            let elementDOMWrapper2 = wrapper.find("[label='VIP等级']");
            elementDOMWrapper2.trigger("click")
            let elementDOMWrapper3 = wrapper.find("[label='凤凰知音终身白金卡']");
            elementDOMWrapper3.trigger("click")
            let elementDOMWrapper4 = wrapper.find("[label='座舱类型']");
            elementDOMWrapper4.trigger("click")
            let elementDOMWrapper5 = wrapper.find("[label='头等舱']");
            elementDOMWrapper5.trigger("click")
            let elementDOMWrapper6 = wrapper.find("[label='行李1类型']");
            elementDOMWrapper6.trigger("click")
            let elementDOMWrapper7 = wrapper.find("[value='普通行李']");
            elementDOMWrapper7.trigger("click")
            wrapper.vm.ruleForm.length1 = 100
            wrapper.vm.ruleForm.weight1 = 100
            wrapper.vm.ruleForm.price = 1000
            let elementDOMWrapper11 = wrapper.find("[id='submit']");
            elementDOMWrapper11.trigger("click")
            setTimeout(function () {
                console.log('waiting over.');
                expect(wrapper.vm.result).to.be.equal(450)
            }, 100)
        });
        it('国内航班-2', () => {
            const wrapper = mount(sw_1);
            wrapper.vm.ruleForm.plane_type = "国内航班"
            wrapper.vm.ruleForm.person_type = "p-1"
            wrapper.vm.ruleForm.person_type = "v-1"
            wrapper.vm.ruleForm.seat_type = "s-2"
            wrapper.vm.ruleForm.region = 0
            wrapper.vm.ruleForm.num = 1
            wrapper.vm.ruleForm.spec1 = "普通行李"
            wrapper.vm.ruleForm.spec2 = 0
            wrapper.vm.ruleForm.length1 = 100
            wrapper.vm.ruleForm.weight1 = 100
            wrapper.vm.ruleForm.length2 = 0
            wrapper.vm.ruleForm.weight2 = 0
            wrapper.vm.ruleForm.price = 1000
            let elementDOMWrapper11 = wrapper.find("[id='submit']");
            elementDOMWrapper11.trigger("click")
            setTimeout(function () {
                console.log('waiting over.');
                expect(wrapper.vm.result).to.be.equal(450);
            }, 1000)
        });
    });
})








