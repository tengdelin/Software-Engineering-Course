<template>
    <view>
        <video
        id="myVideo"
        :src="videoSrc" 
        autoplay="true"
        loop="true"
        enable-danmu="true" 
        danmu-btn="true"
        :danmu-list="danmuList"
        muted="true"
        >
        </video>
        <view class="inputBox">
            <input 
            type="text" 
            value="" 
            placeholder="输入弹幕内容"
            @blur="input"
            />
        </view>
        <button type="default" @tap="bindSendDanmu">发送弹幕</button>
    </view>
</template>

<script>
    export default {
        data() {
            return {
                videoSrc:'http://photo.tdl.cool/big_buck_bunny.mp4',
                danmuList: [
                    {
                        text:'这也太好看了吧！', //弹幕文本内容
                        color: '#a52664', //弹幕文字颜色
                        time: 2 // 这条弹幕在视频播放2秒后播放
                    },
                    {
                        text:'地大yyds！！！',//文本
                        color: '#e8853b',
                        time: 4
                    },
                    {
                        text:'这动画片真不错~',//文本
                        color: '#b31f45',
                        time: 6
                    },
					{
					    text:'智能终端！！！',//文本
					    color: '#b31881',
					    time: 8
					}
                ],
                inputValue: ''
            }
        },
        onLoad() {//监听页面加载
            this.videoContext = uni.createVideoContext('myVideo') 
            //创建一个视频上下文的操作对象，通过id标识获取myVideo
        },
        methods:{
            input:function(e){ //获取用户输入的弹幕内容
                console.log(e)
                this.inputValue = e.detail.value //将拿到的用户弹幕内容显示到屏幕上
            },
            bindSendDanmu:function(){//实现发送弹幕的功能
                this.videoContext.sendDanmu({
                    text: this.inputValue ,//将拿到的用户弹幕内容发送到屏幕上
                    color:"red" //弹幕文本颜色
                })
            }
        }
    }
</script>

<style lang="scss">
    video {
        width: 750upx;
    }

    .inputBox {
        width: 750upx;
        height: 90upx;
        margin-bottom: 10upx;
        input {
            width: 100%;
            height: 90upx;
            border: 1upx solid #808080;
            border-radius: 20upx;
        }
    }
</style>