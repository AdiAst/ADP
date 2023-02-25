<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header/ClassicNavbar.jsp">
	<jsp:param value="${title}" name="title" />
</jsp:include>


<h1 class="text-center mt-5 mb-3">You Search For ${search}</h1>
<div class="container-fluid d-flex flex-wrap">
<c:forEach items="${cars}" var="car">
    <div class="col-md-4">
      <div class="card m-3">
        <img src="${car.getPhotosImagePath() }" width="auto" height="300px" class="card-img-top" alt="${car.name}">
        <div class="card-body">
          <h5 class="card-title">${car.name} | Posted By: ${car.postedBy}</h5>
          <p class="card-text">Make: ${car.make}</p>
          <p class="card-text">Model: ${car.model}</p>
          <p class="card-text">Year: ${car.year}</p>
          <p class="card-text">Price: $${car.price}</p>
          <a href="car-detail?id=${car.id}" class="btn btn-primary">View Details</a>
        </div>
      </div>
    </div>
  </c:forEach>
</div>


<jsp:include page="footer/ClassicFooter.jsp"></jsp:include> 