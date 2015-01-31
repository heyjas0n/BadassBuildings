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
    <title></title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="span8 offset2">

            <h1>Edit Floors For ${building.name}</h1>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Specify floor number between 1 and ${building.floors}: </th>
                        <th>Number of Rooms (Must be at least 1)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${building.floors}" var="floor">
                        <tr> <td>${floor.number}</td>
                        </tr>
                    </c:forEach>
                            Floor Number: <input type="text" name="floorNumber">
                            <br />
                            Num Rooms: <input type="text" name="numRooms" />
                            <input type="submit" value="Submit" />
                    </tbody>
                </table>
        </div>
    </div>
</div>
</body>
</html>
