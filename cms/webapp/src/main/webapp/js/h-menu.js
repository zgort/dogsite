$(document).ready(function(){
    initHMenu();
});

function initHMenu(){
    $(".h-menu li").hover(function(){
        $(this).find("ul.level-two").css("display","block");
        var width = $(this).width();
        if($(this).find("ul.level-two li").width() <=  width) {
            $(this).find("ul.level-two li").css({'width': width - 3});
        }
    },function(){
        $(this).find("ul.level-two").css("display","none");
    });

    $(".h-menu .level-two li").hover(function(){
        var $thirdLevelMenu = $(this).find("ul.level-three");
        if($thirdLevelMenu  != null || $thirdLevelMenu  != undefined){
            $thirdLevelMenu.css("display","block");
            var width = $(this).width();
            $thirdLevelMenu.css("left", width + 5);
        }

    },function(){
        $(this).find("ul.level-three").css("display","none");
    });
}