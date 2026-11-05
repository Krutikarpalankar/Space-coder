import React from "react";
import { useEffect, useState } from "react";
import axiosInstance from "../Services/api";
import {Link} from "react-router-dom";
import "../index.css";
const Problems = () => {
  let [problems, setProblems] = useState([]);
  useEffect(() => {
    axiosInstance
      .get("/coding/problems")
      .then((response) => {
        console.log("Response data:", response.data);

        setProblems(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);
  console.log(problems);
  return (
    <div className="problems-container">
      <h1>Problems</h1>

       {problems.map((problem) => (
                <div className="card p-3 mb-3" key={problem.probId}>

                    <h3>{problem.probTitle}</h3>

                    <p>{problem.probDifficulty}</p>

                    <Link
                        to={`/problems/${problem.probId}`}
                        className="btn problem-subBtn" style={{backgroundColor:"#748D92", width:"130px"}}
                    >
                        Solve Problem
                    </Link>

                </div>
            ))}
    </div>
  );
};

export default Problems;


