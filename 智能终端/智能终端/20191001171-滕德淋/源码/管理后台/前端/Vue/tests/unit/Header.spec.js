import {expect} from 'chai'
import {mount} from '@vue/test-utils'
import header from '@/components/Header'

//该部分只为UI测试，进行练手的测试单元而已
describe('测试Header', () => {
    it('title', () => {
        const wrapper = mount(header);
        expect(wrapper.vm.title).to.be.equal('软件测试')
    })
    it('nickname', function () {
        const wrapper = mount(header);
        expect(wrapper.vm.user.nickName).to.be.equal("小滕")
    });
    it('userinfo', function () {
        const wrapper = mount(header);
        expect(wrapper.vm.userinfo).to.be.equal("个人信息")
    });
    it('userinfo', function () {
        const wrapper = mount(header);
        expect(wrapper.vm.logout).to.be.equal("退出系统")
    });
})
