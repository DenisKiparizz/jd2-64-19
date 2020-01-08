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
            if (s1.value == "Honda") {
                var optionArray = ["|", "civic|Civic", "accord|Accord", "prelude|Prelude"];
            } else if (s1.value == "Nissan") {
                var optionArray = ["|", "skyline|Skyline", "gt-r|GT-R", "200sx|200SX"];
            } else if (s1.value == "Tesla") {
                var optionArray = ["|", "ModelS|ModelS", "ModelF|ModelF", "CyberTruck|CyberTruck"];
            } else if (s1.value == "Acura") {
                var optionArray = ["|", "RSX|RSX", "MDX|MDX", "TSX|TSX"];
            } else if (s1.value == "Toyota") {
                var optionArray = ["|", "Celica|Celica", "Corolla|Corolla", "RAV4|RAV4"];
            } else if (s1.value == "BMW") {
                var optionArray = ["|", "x5|X5", "e30|e30"];
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
      action="${pageContext.request.contextPath}/addOrder">

    <div id="container">
        <div id="header">
            <h1><strong>WestCostCustoms</strong>Cars&Momey</h1>
            <h2>By Xzibit and Denis Solodkiy</a> for Academy <a
                    href="http://forrst.com/posts/Competition_Create_a_Pure_CSS_Drop_Down_Menu-PcD">West Cost</a></h2>
        </div>
        <h1>Full information about your car </h1>
        <span class="custom-dropdown big">
            <br>
            Make:
                    <select id="slct1" name="make" onchange="populate(this.id,'slct2')">
                    <option value=""></option>
                    <option value="Honda">Honda</option>
                    <option value="BMW">BMW</option>
                    <option value="Nissan">Nissan</option>
                    <option value="Acura">Acura</option>
                    <option value="Toyota">Toyota</option>
                    <option value="Tesla">Tesla</option>
                </select>
                              <hr/>
                    Model:
               <select id="slct2" name="model"></select>
Type of Body:
            <select name="body" size="1" title="Type of Body">
                <option value=""></option>
                <option value="Sedan">Sedan</option>
                <option value="Coupe">Coupe</option>
                <option value="Hatch-Back">Hatch-Back</option>
                <option value="Minivan">Minivan</option>
                <option value="Estate">Estate</option>
                <option value="Roadster">Roadster</option>
            </select>
            Type of Engine:
                <select name="typeOfEngine" size="1" title="Type of Engine">
                    <option value=""></option>
                    <option value="Gas">Gas</option>
                    <option value="Disel">Disel</option>
                    <option value="Electro">Electro</option>
            </select>
            Age:
          <select name="age" size="1" title="Age">
                    <option value=""></option>
                    <option value="1990">1990</option><option value="1991">1990</option>
                    <option value="1992">1990</option><option value="1993">1990</option>
                    <option value="1994">1990</option><option value="1995">1990</option>
                    <option value="1996">1990</option><option value="1997">1990</option>
                    <option value="1998">1990</option><option value="1999">1990</option>
                    <option value="2000">2000</option><option value="2010">2010</option>
                    <option value="2000">2000</option><option value="2001">2001</option>
                    <option value="2002">2002</option><option value="2003">2003</option>
                    <option value="2004">2004</option><option value="2005">2005</option>
                    <option value="2006">2006</option><option value="2007">2007</option>
                    <option value="2008">2008</option><option value="2009">2009</option>
                    <option value="2010">2010</option><option value="2011">2011</option>

          </select>
         <select name="valueOfEngine" size="1" title="Value Of Engine">
             <option value="">Value Of Engine</option>
                    <option value="1.0">1.0</option>
                    <option value="1.2">1.2</option>
                    <option value="1.5">1.5</option>
                    <option value="1.6">1.6</option>
                    <option value="1.8">1.8</option>
                    <option value="2.0">2.0</option>
                    <option value="2.2">2.2</option>
                    <option value="2.3">2.3</option>
                    <option value="2.5">2.5</option>
                    <option value="2.8">2.8</option>
                    <option value="3.0">3.0</option>
                    <option value="3.5">3.5</option>
                    <option value="4.0">4.0</option>
                    <option value="4.4">4.4</option>
                    <option value="5.0">5.0</option>
                </select>
             <input type="submit" value="Save"/>

        </span>
    </div>
</form>
</body>
</html>
