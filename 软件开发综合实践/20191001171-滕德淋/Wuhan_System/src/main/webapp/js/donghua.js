(function(){
	window.exit = [];
	window.enter = [];

	exit[0] = function(){
		console.log("我是0退");

		$(".logo img").fadeOut();

		$(".skin1 img").velocity({
			"translateX" : -100
		},200).velocity({
			"translateX" : 200
		},200).velocity({
			"translateX" : 0
		},200).velocity({
			"translateZ" : 301
		},200,function(){
			$(this).hide();
			$(this).velocity({
				"translateZ" : 0
			})
		});

		$(".skin2 img").slideUp();
	}
	exit[1] = function(){
		console.log("我是1退");

		$(".number47 img").velocity({
			"translateZ" : 401
		},400,function(){
			$(this).velocity({
				"translateZ" : 0
			},0)
			$(this).hide();
		});
	}
	exit[2] = function(){
		console.log("我是2退");
		$(".page2h p").fadeOut();
	}
	exit[3] = function(){
		console.log("我是3退");
		$(".page3h p").fadeOut();
	}


	//*************************************************
	enter[0] = function(){
		console.log("我是0进");

		$(".logo img").show().velocity({
			"translateZ" : 301
		},100)
		.velocity("reverse",{"duration" : 500});

		$(".skin1 img").show().velocity({
			"translateX" : 0,
			"rotateY" : 740,
			"translateZ" : 601
		},0)
		.delay(400).velocity("reverse",{"duration" : 900});

		$(".skin2 img").show().velocity({
			"translateZ" : 301
		},0)
		.delay(1400).velocity({
			"translateZ" : 0
		},600,function(){
			lock = true;
		});
	}
	enter[1] = function(){
		console.log("我是1进");

		$(".clock").show().velocity({
			"rotateY" : -40,
			"translateZ" : 400,
		},0).delay(400).velocity({
			"translateZ" : -800,
			"rotateY" : 0,
			"scale" : 0.4
		},800,[0.4,0.4,0.4,0.4]).velocity({
			"rotateX" : 10,
			"rotateY" : 30,
			"translateZ" : 401,
			"scale" : 1
		},800);


		$(".number47 img").show().velocity({
			"opacity" : 0,
			"scale" : 0.01
		},0).delay(1700).velocity({
			"opacity" : 1,
			"scale" : 1
		},800,function(){
			lock = true;
		});
	}
	enter[2] = function(){
		console.log("我是2进");
		
		$(".page2h p").show().velocity({
			"translateZ" : 400
		},0).velocity({
			"translateZ" : 0
		},500,function(){
			lock = true;
		});
	}
	enter[3] = function(){
		console.log("我是3进");
		lock = true;
		$(".page3h p").show().velocity({
			"translateZ" : 400
		},0).velocity({
			"translateZ" : 0
		},500,function(){
			lock = true;
		});
	}
})();