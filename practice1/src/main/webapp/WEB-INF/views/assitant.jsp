<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<!-- Title -->
	<title>deptintro</title>
	<!-- Meta -->
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
	<!-- Favicon -->
	<link href="favicon.html" rel="shortcut icon">
	<!-- Bootstrap Core CSS -->
	<link rel="stylesheet" href="css/bootstrap.css" rel="stylesheet">
	<!-- Template CSS -->
	<link rel="stylesheet" href="css/animate.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome.css" rel="stylesheet">
	<link rel="stylesheet" href="css/nexus.css" rel="stylesheet">
	<link rel="stylesheet" href="css/responsive.css" rel="stylesheet">
	<link rel="stylesheet" href="css/custom.css" rel="stylesheet">
	<!-- Google Fonts-->
	<link href="http://fonts.googleapis.com/css?family=Lato:400,300" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" rel="stylesheet" type="text/css">
</head>

<body>
	<%@include file="jspf/MISwebsiteNavbar.jspf"%>
    	
        <div id="content" class="container">
            <!-- === BEGIN CONTENT === -->    
            <div class="row margin-vert-30">
			<%@ include file="jspf/Sidebar.jsp" %>
			       
            
            <div class="col-md-9">
            <h2 class="margin-bottom-30">行政同仁</h2>
            
	<c:forEach items="${assitantList}" var="assitant">
            
            <!-- Accordion -->
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                        <a class="accordion-toggle" data-parent="#accordion" data-toggle="collapse">
                            ${assitant.m_name}
                        </a>
                        </h4>
                    </div>
                    <div class="accordion-body collapse in">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-5"><img src="img/asistant/${assitant.tea_photo}" width="300px" height="256px"></div>
                                <div class="col-md-7">
                                    <h3 class="no-margin no-padding">${assitant.post_name}</h3>
                                    <br />
                                    <p>${assitant.m_phone}</p>
                                    <p>${assitant.m_email}</p>
                                    <p>${assitant.location}</p>
                                    
                                  	<br /><p></p>  
                                    <c:forEach items="${assitant.assitantworkList}" var="workList">	                                    
                                    	${workList.workContent}
                                    	<br />
                                   	</c:forEach> 
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--   
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                        <a class="accordion-toggle" href="#collapse-Two" data-parent="#accordion" data-toggle="collapse">
                         		 聯絡資訊
                        </a>
                        </h4>
                    </div>
                    <div class="accordion-body collapse">
                        <div class="panel-body">
                            <p>Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</p>
                        </div>
                    </div>
                </div>
                
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                        <a class="accordion-toggle" href="#collapse-Three" data-parent="#accordion" data-toggle="collapse">
                            	相關業務
                        </a>
                        </h4>
                    </div>
                    <div class="accordion-body collapse">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-5"><img src="img/frontpage/filler3.jpg" alt="filler image"></div>
                                <div class="col-md-7">
                                    <h3 class="no-margin no-padding">Mirum Est Notare</h3>
                                    <p>Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothicas.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                -->
                
            </div>
            <!-- End Accordion -->
            
	</c:forEach>            
            
            
            <div class="margin-bottom-30"><hr></div>
            
              
            <!-- Tab v1 -->
            <!--
            <div class="tabs">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#sample-1a" data-toggle="tab">Sample Heading 1</a></li>
                    <li><a href="#sample-1b" data-toggle="tab">Sample Heading 2</a></li>
                    <li><a href="#sample-1c" data-toggle="tab">Sample Heading 3</a></li>
                    <li><a href="#sample-1d" data-toggle="tab">Sample Heading 4</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="sample-1a">
                        <div class="row">
                            <div class="col-md-5"><img src="img/frontpage/filler1.jpg" alt="filler image"></div>
                            <div class="col-md-7">
                                <h3 class="no-margin no-padding">Humanitatis Per Seacula</h3>
                                <p>Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothicas.</p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="tab-pane fade in" id="sample-1b">
                        <p>Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.</p>
                        <div class="clearfix"></div>
                    </div>
                    <div class="tab-pane fade in" id="sample-1c">
                        <div class="row">
                            <div class="col-md-5"><img src="img/frontpage/filler3.jpg" alt="filler image"></div>
                            <div class="col-md-7">
                                <h3 class="no-margin no-padding">Mirum Est Notare</h3>
                                <p>Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothicas.</p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="tab-pane fade in" id="sample-1d">
                        <p>Vivamus imperdiet condimentum diam, eget placerat felis consectetur id. Donec eget orci metus, Vivamus imperdiet condimentum diam, eget placerat felis consectetur id. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, ante ac interdum ullamcorper. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, consectetur id.</p>
                        <ul>
                            <li>Donec eget orci metus</li>
                            <li>Ante ac interdum ullamcorper</li>
                            <li>Vivamus imperdiet condimentum</li>
                            <li>Pellentesque fermentum</li>
                        </ul>
                    </div>
                </div>
            </div>
            -->
            <!-- End Tab v1 -->           
        </div>
    </div>
</div>
<!-- === END CONTENT === -->

	<%@include file="jspf/MISwebsiteFooter.jspf"%>
<!-- JS -->
<script type="text/javascript" src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<!-- Isotope - Portfolio Sorting -->
<script type="text/javascript" src="js/jquery.isotope.js" type="text/javascript"></script>
<!-- Mobile Menu - Slicknav -->
<script type="text/javascript" src="js/jquery.slicknav.js" type="text/javascript"></script>
<!-- Animate on Scroll-->
<script type="text/javascript" src="js/jquery.visible.js" charset="utf-8"></script>
<!-- Slimbox2-->
<script type="text/javascript" src="js/slimbox2.js" charset="utf-8"></script>
<!-- Modernizr -->
<script src="js/modernizr.custom.js" type="text/javascript"></script>
<!-- End JS -->


</body>
</html>