
<html>
<head>
<title>Crunchify - Spring MVC Upload Multiple Files Example</title>

<style type="text/css">
body {
    background-image:
        url('http://cdn3.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>

	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<html lang="en">
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
    <br>
    <br>
    <div align="center">
        <h1>Crunchify - Spring MVC Upload Multiple Files Example</h1>
 
        <form:form method="post" action="savefiles"
            modelAttribute="uploadForm" enctype="multipart/form-data">
 
            <p>Select files to upload. Press Add button to add more file
                inputs.</p>
 
            <table id="fileTable">
                <tr>
                    <td><input name="files[0]" type="file" /></td>
                </tr>
                <tr>
                    <td><input name="files[1]" type="file" /></td>
                </tr>
            </table>
            <br />
            <input type="submit" value="Upload" />
            <input id="addFile" type="button" value="Add File" />
        </form:form>
 
        <br />
    </div>
</body>
</html>