<%--
  Created by IntelliJ IDEA.
  User: jnguyen
  Date: 1/30/2015
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Floors</title>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="resources/css/bootstrap.min.css" rel="stylesheet" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <link href="resources/css/bootstrap-editable.css" rel="stylesheet">
    <script src="resources/js/bootstrap-editable.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="span8 offset2">

            <h1>Edit Floors For ${building.name}</h1>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Specify floor number between 1 and ${building.numFloors}: </th>
                        <th>Number of Rooms (Must be at least 1)  </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${building.floors}" var="currentfloor">
                        <tr>
                            <td>

                            </td>
                            <td>Floor Name: ${currentfloor.number}</td>
                            <td>Number of Rooms: ${currentfloor.numRooms}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        </div>
    </div>
</div>
</body>
</html>
