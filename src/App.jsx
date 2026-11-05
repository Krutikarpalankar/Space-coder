
import { Routes, Route } from 'react-router-dom';
import Dashboard from './Pages/Dashboard';
import Certificate from './Pages/Certificates';
import  Hackthons from './Pages/Hackthons';
import Nav from './Nav';
import Leaderboard from './Pages/Leaderboard';
 import Problems from './Pages/Problems';
 import ProblemDetails from './Pages/ProblemDetails';
 import Resister from './Pages/Register';
 import Submission from './Pages/Submissions';
 import SubmissionResult from "./Pages/SubmissionResult";
import MySubmissions from "./Pages/MySubmissions";
 function App() {
  return (
    <div>
     <Nav/>

      <Routes>
        
        <Route
          path="/"
          element={<Dashboard/>}
        />
      </Routes>
      <Routes>
        <Route
          path="certificates"
          element={<Certificate/>}
        />
      </Routes>
      <Routes>
        <Route
          path="hackthons"
          element={<Hackthons/>}
        />
      </Routes>
      
      <Routes>
        <Route
          path="leaderboard"
          element={<Leaderboard/>}
        />
      </Routes>
      <Routes>
        <Route
          path="certificates"
          element={<Certificate/>}
        />
      </Routes>
      
      <Routes>
        <Route
          path="problems"
          element={<Problems/>}
        />
      </Routes>
      <Routes>
        <Route
          path="problems/:id"
          element={<ProblemDetails/>}
        />
      </Routes>
      <Routes>
        <Route
          path="register"
          element={<Resister/>}
        />
      </Routes>
      <Routes>
        <Route
          path="submissions/:id"
          element={<SubmissionResult/>}
        />
      </Routes>
    
       
      <Routes>
        <Route
          path="/my-submissions"
          element={<MySubmissions/>}
        />
      </Routes>
      
      
    </div>
  );
}

export default App;