<template>
	<view class="contact">
		<image class="img" src="http://photo.tdl.cool/bgm.jpg"></image>
		<view class="info">
			<view @click="phone">联系电话：15884113649 ( 点击拨打 )</view>
			<view>联系地点：中国地质大学(武汉)未来城校区</view>
		</view>
		<map class="map" :longitude="longitude" :scale="scale" :latitude="latitude" :markers="markers"></map>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				longitude: 114.617139,
				latitude: 30.457575,
				scale: 16,
				markers: [{
					longitude: 114.617139,
					latitude: 30.457575,
					iconPath: '../../static/cug.png',
					width: 30,
					height: 30
				}]
			}
		},
		methods: {
			phone() {
				uni.makePhoneCall({
					phoneNumber: '15884113649'
				})
			}
		}
	}
</script>

<style lang="scss">
	.contact {
		.img {
			width: 750rpx;
			height: 320rpx;
		}

		.info {
			padding: 10rpx 20rpx;
			font-size: 30rpx;

			view {
				line-height: 80rpx;
				border-bottom: 1px solid #eee;
			}
		}

		.map {
			width: 750rpx;
			height: 750rpx;
		}
	}
</style>
