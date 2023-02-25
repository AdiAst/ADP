<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ page isELIgnored="false" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Store List</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
      integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
      integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
      crossorigin="anonymous"
    ></script>
  </head>

<body>
  <!-- Breadcrumb -->
<nav class="m-3" style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="home">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Store List</li>
  </ol>
</nav>
  <div class="container mt-5">
  <h1>Store List</h1>
    <table class="table table-dark table-hover">
      <thead>
        <tr>
          <th>Store Name</th>
          <th>Phone Number</th>
          <th>Localities</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <!-- Using JSTL Core to do the looping for each data -->
        <c:forEach items="${stores}" var="store">
          <tr>
            <!-- Store Name -->
            <td>${store.getName()}</td>

            <!-- Stone Phone Number -->
            <td>${store.getPhoneNumber()}</td>

            <!-- Store Location -->
            <td>
              <c:forEach var="location" items="${store.getLocalities()}">
                <span> ${location}</span>
              </c:forEach>
            </td>

            <!-- Button to Add another Store -->
            <td>
              <a class="btn btn-success" href="add">ADD STORE</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
