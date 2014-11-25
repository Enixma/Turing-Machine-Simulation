Turing-Machine-Simulation
=========================
The simulator creates a Turing Machine based on user input of a set of states Q, an  input alphabet Σ, a tape alphabet Γ, transition functions δ, a start state q, and an input string. The simulation displays the entire mechanics of the Turing Machine which involve the State control, the tape head, and the tape.

Quick Demo on Youtube
---------------------
<a href="https://www.youtube.com/watch?v=u_rwcAbG5pQ" target="_blank"><img src="http://i58.tinypic.com/kcmblu.png" 
alt="CLICK TO VIEW THE DEMO" width="620" height="434" border="10" /></a>

Limitations
-----------
The simulator limits 2 features of Turing Machine which are the number of tape and the number of tape cell. By the definition, a Turing Machine has k tapes, for some fixed k ≥ 1 and each tape contains infinite number of cells. In this project, the number of tape is limited to 1 and the number of cell is limited to 33. The leftmost and the rightmost cells, each contains a Blank symbol to signifies the end of the of the tape. Consequently, User can only provide an input string with the maximum length of 31.

Dependency
----------
The application is developed with JDK7.
