<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container">
	    <a class="navbar-brand" href="/dashboard">
	      <img src="/logo/gotnxt_logo_transparent.png" alt="" width="" height="">
	    </a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse d-flex justify-content-between align-items-center" id="navbarNavAltMarkup">
	      <div class="navbar-nav">
	        <a class="nav-link active me-2" aria-current="page" href="/dashboard">Home</a>
	        <a class="nav-link me-2" href="/event/new">Create New Event</a>
	        <a class="nav-link me-2" href="/archives">Archived Events</a>
	        <a class="nav-link me-2" href="/portfolio">My Events</a>
	      </div>
	      <div class="navbar-nav">
	        <a class="nav-link me-2 btn btn-outline-danger btn-sm " data-bs-toggle="modal" data-bs-target="#loggedOut" href="/logout">Logout</a>
	      </div>
	  	</div>
	  	
	  	<!-- Model -->
	  	<div class="modal fade" id="loggedOut" tabindex="-1" aria-hidden="true">
	  		<div class="modal-dialog modal-sm">
	  			<div class="modal-content">
	  				<div class="modal-header">
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
	  				<div class="modal-body">
	  					<p>Leaving so soon?</p>
	  					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Never Mind</button>
        				<a href="/logout" class="btn btn-primary">Bye!</a>
	  				</div>
	  			</div>
	  		</div>
	  	</div>
	  </div>
	</nav>
</header>