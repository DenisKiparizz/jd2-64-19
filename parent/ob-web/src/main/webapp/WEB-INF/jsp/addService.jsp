<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Full information</title>
    <style>
        <%@include file="/WEB-INF/css/carOptions.css"%>
    </style>
    <script>
        function populate(s1, s2) {
            var s1 = document.getElementById(s1);
            var s2 = document.getElementById(s2);
            s2.innerHTML = "";
            if (s1.value == "Engine") {
                var optionArray = ["|", "Check Engine|Check Engine",
                    "Alter oil|Alter oil", "bla|bla"];
            } else if (s1.value == "The brakes") {
                var optionArray = ["|", "Check Brakes|Check Brakes",
                    "Alter brakes|Alter brakes",
                    "Do stronger|Do stronger"];
            } else if (s1.value == "Body") {
                var optionArray = ["|", "Check geometry|Check geometry",
                    "Repair small details|Repair small details",
                    "Welding|Welding"];
            }
            for (var option in optionArray) {
                var pair = optionArray[option].split("|");
                var newOption = document.createElement("option");
                newOption.value = pair[0];
                newOption.innerHTML = pair[1];
                s2.options.add(newOption);
            }
        }
    </script>
</head>
<body>



<form method="post"
      action="${pageContext.request.contextPath}/addService">
    <div id="container">
        <div id="header">
            <h1><strong>WestCostCustoms</strong>Cars&Repair</h1>
            <h2>By Xzibit and Team</a>for Academy <a
                    href="http://forrst.com/posts/Competition_Create_a_Pure_CSS_Drop_Down_Menu-PcD">West Cost</a></h2>
        </div>
        <h1>Full information about your car </h1>


        <span class="custom-dropdown big">
            <br>
            Type of Repair
                    <select id="slct1" name="typeOfService" onchange="populate(this.id,'slct2')">
                    <option value=""></option>
                    <option value="Engine">Engine</option>
                    <option value="The brakes">The brakes</option>
                    <option value="Body">Body</option>
                </select>
            <hr/>
                    Name of Service:
               <select id="slct2" name="nameOfService"></select>
Description:
            <label> Description:: <input type="text" name="description"></label>
             <input type="submit" value="Save"/>
            Car id:
            <label> Car id:: <input type="number" name="car_id"></label>
             <input type="submit" value="Save"/>
        </span>
    </div>
</form>
</body>
</html>
