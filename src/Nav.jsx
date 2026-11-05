import React from 'react'
import {Link} from 'react-router-dom'

const Nav = () => {
  return (
    
<nav  className=" navbar navbar-expand-lg " style={{backgroundColor:"#124E66",width:'100%',textDecoration:'#D3D9D4'}}  >
  
  <div className="container-fluid"  >
    <a className="navbar-brand" href="#"style={{textDecoration:'none',color:"white", boxShadow:'2px 2px 4px rgba(0,0,0,0.1)'}}>Navbar</a>
    <button className="navbar-toggler"style={{color:"#D3D9D4"}} type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"style={{color:"#D3D9D4"}} ></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNav">
      <ul className="navbar-nav" >
        <li className="nav-item">
          <a className="nav-link active" aria-current="page" href="#" style={{color:"white"}}>Home</a>
        </li>
        <li className="nav-item">
         <Link className="nav-link active" to="/" style={{color:"#D3D9D4"}}>Dashboard</Link>
        </li>
        <li className="nav-item">
         <Link className="nav-link" to="/certificates" style={{color:"#D3D9D4"}}>Certificates</Link>
        </li>
        <li className="nav-item">
         <Link className="nav-link" to="/hackthons" style={{color:"#D3D9D4"}}>Hackthons</Link>
        </li>
        <li className="nav-item">
         <Link className="nav-link" to="/leaderboard" style={{color:"#D3D9D4"}}>Leaderboard</Link>
        </li>
        <li className="nav-item">
        <Link className="nav-link" to="/problems" style={{color:"#D3D9D4"}}>
                        Problems
                    </Link>
        </li>
        <li className="nav-item">
         <Link className="nav-link" to="/register" style={{color:"#D3D9D4"}}>Register</Link>
        </li>
        <li className="nav-item">
           <Link className="nav-link" to="/my-submissions" style={{color:"#D3D9D4"}}>
                        My Submissions
                    </Link>
        </li>
      </ul>
    </div>
  </div>
</nav>
  )
}

export default Nav
  