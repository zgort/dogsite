<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@include file="../../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/js/JssorSlider/css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/js/JssorSlider/jssor.slider.min.js"></script>
<script type="text/javascript">
	var jssor_slider1
	init_jssor_slider1 = function(containerId) {
		var options = {
			$AutoPlay : true, //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
			$SlideDuration : 500, //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
			$ArrowKeyNavigation : true, //[Optional] Allows keyboard (arrow key) navigation or not, default value is false
			$ArrowNavigatorOptions : { //[Optional] Options to specify and enable arrow navigator or not
				$Class : $JssorArrowNavigator$, //[Requried] Class to create arrow navigator instance
				$ChanceToShow : 1
			//[Required] 0 Never, 1 Mouse Over, 2 Always
			},

			$ThumbnailNavigatorOptions : {
				$Class : $JssorThumbnailNavigator$, //[Required] Class to create thumbnail navigator instance
				$ChanceToShow : 2, //[Required] 0 Never, 1 Mouse Over, 2 Always

				$ActionMode : 1, //[Optional] 0 None, 1 act by click, 2 act by mouse hover, 3 both, default value is 1
				$AutoCenter : 3, //[Optional] Auto center thumbnail items in the thumbnail navigator container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 3
				$Lanes : 1, //[Optional] Specify lanes to arrange thumbnails, default value is 1
				$SpacingX : 3, //[Optional] Horizontal space between each thumbnail in pixel, default value is 0
				$SpacingY : 3, //[Optional] Vertical space between each thumbnail in pixel, default value is 0
				$DisplayPieces : 9, //[Optional] Number of pieces to display, default value is 1
				$ParkingPosition : 250, //[Optional] The offset position to park thumbnail
				$Orientation : 1, //[Optional] Orientation to arrange thumbnails, 1 horizental, 2 vertical, default value is 1
				$DisableDrag : false
			//[Optional] Disable drag or not, default value is false,
			}
		};

		jssor_slider1 = new $JssorSlider$(containerId, options);
	};

	$(document).ready(function() {
		init_jssor_slider1("slider1_container");
		//responsive code begin
		//you can remove responsive code if you don't want the slider scales while window resizes
		function ScaleSlider() {

			//reserve blank width for margin+padding: margin+padding-left (10) + margin+padding-right (10)
			var paddingWidth = 0;

			//minimum width should reserve for text
			var minReserveWidth = 150;

			var parentElement = jssor_slider1.$Elmt.parentNode;

			//evaluate parent container width
			var parentWidth = parentElement.clientWidth;

			if (parentWidth) {

				//exclude blank width
				var availableWidth = parentWidth - paddingWidth;

				//calculate slider width as 78% of available width
				var sliderWidth = availableWidth * 0.79;

				//slider width is maximum 600
				sliderWidth = Math.min(sliderWidth, 600);

				//slider width is minimum 200
				sliderWidth = Math.max(sliderWidth, 200);

				//evaluate free width for text, if the width is less than minReserveWidth then fill parent container
				if (availableWidth - sliderWidth < minReserveWidth) {

					//set slider width to available width
					sliderWidth = availableWidth;

					//slider width is minimum 200
					sliderWidth = Math.max(sliderWidth, 200);
				}

				jssor_slider1.$ScaleWidth(sliderWidth);
			} else
				window.setTimeout(ScaleSlider, 30);
		}
		ScaleSlider();

		$(window).bind("load", ScaleSlider);
		$(window).bind("resize", ScaleSlider);
		$(window).bind("orientationchange", ScaleSlider);
		//responsive code end
	});
</script>


    <div class="page_conetnt">
        <div class="left_column">
            <h3 class="list_header">${dog.name}</h3>
            <div style="display: block; margin: 20px auto 0 auto; padding: 10px 5px 5px 10px; width: 77%; max-width:940px; min-width: 240px;">
                <div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 600px;height: 400px;">
                    <!-- Slides Container -->
                    <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 400px; overflow: hidden;">
						<c:forEach items="${dog.images}" var="image" varStatus="status">
                        <div>
                            <img u="image" class="slide_img" src="/image/${image.fileName}" />
                            <img u="thumb" class="thumb" src="/image/${image.fileName}" />
                        </div>
                        </c:forEach>
                    </div>
                    <!-- Arrow Left -->
                    <span u="arrowleft" class="jssora05l" style="top: 158px; left: 8px;">
                    </span>
                    <!-- Arrow Right -->
                    <span u="arrowright" class="jssora05r" style="top: 158px; right: 8px">
                    </span>
                    <div u="thumbnavigator" class="jssort15" style="left: 0px; bottom: 0px;">
                        <!-- the following background element is optional -->
                        <div style=" background-color: #000; filter:alpha(opacity=30); opacity:.3; width: 100%; height:100%;"></div>

                        <!-- Thumbnail Item Skin Begin -->
                        <div u="slides" style="cursor: default;">
                            <div u="prototype" class=p>
                                <div u="thumbnailtemplate" class=t></div>
                            </div>
                        </div>
                        <!-- Thumbnail Item Skin End -->
                    </div>
                </div>
            </div>
            <div class="desc_div">
                <p>D.O.B: ${dog.dateOfBirth}</p>
                <p>${dog.desc}</p>
            </div>
        </div>
        <div class="right_column">
            <div class="news_feeds">
                <h3 class="page-header">Side Module</h3>
                <div class="custom">
                    <p>This is a module where you might want to add some more information or an image,  a link to your social media presence, or whatever makes sense for your site.</p>
                    <p>You can edit this module in the module manager. Look for the Side Module.</p>
                </div>
            </div>
            <div class="right_links">
                <ul class="right_link_list">
                    <li>
                        <a href="#">Link 1</a>
                    </li>
                    <li>
                        <a href="#">Link 2</a>
                    </li>
                </ul>
            </div>
            <div class="visitors_number">
                Visitor Number: 13599
            </div>
        </div>
    </div>
  
<%@include file="../../footer.jsp"%>