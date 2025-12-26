/**
 * 
 */



const BASE_URL = "http://localhost:8080/student";

document.getElementById("studentForm").addEventListener("submit", function(e){
    e.preventDefault();

    const id = document.getElementById("studentId").value;
    const student = {
        name: document.getElementById("name").value,
        age: parseInt(document.getElementById("age").value),
        course: document.getElementById("course").value,
        address: document.getElementById("address").value
    };

    if(id){ // Update whole student
        fetch(`${BASE_URL}/update/${id}`, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(student)
        }).then(res => res.json())
          .then(data => { alert("Student updated"); resetForm(); fetchStudents(); });
    } else { // Add student
        fetch(`${BASE_URL}/save`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(student)
        }).then(res => res.json())
          .then(data => { alert("Student added"); resetForm(); fetchStudents(); });
    }
});

function fetchStudents(){
    fetch(`${BASE_URL}/fetchAll`)
        .then(res => res.json())
        .then(data => displayStudents(data));
}

function searchByName(){
    const name = document.getElementById("searchName").value;
    if(!name) return alert("Enter name to search");
    fetch(`${BASE_URL}/${name}`)
        .then(res => res.json())
        .then(data => displayStudents([data]));
}

function searchByCourse(){
    const course = document.getElementById("searchCourse").value;
    if(!course) return alert("Enter course to search");
    fetch(`${BASE_URL}/course/${course}`)
        .then(res => res.json())
        .then(data => displayStudents([data]));
}

// Update course only
function updateCourse(id){
    const newCourse = prompt("Enter new course:");
    if(!newCourse) return;
    fetch(`${BASE_URL}/${id}/${newCourse}`, { method: "PATCH" })
        .then(res => res.json())
        .then(data => { alert("Course updated"); fetchStudents(); });
}

// Delete one student
function deleteStudent(id){
    fetch(`${BASE_URL}/delete/${id}`, { method: "DELETE" })
        .then(res => res.json())
        .then(data => { alert("Student deleted"); fetchStudents(); });
}

// Delete all students
function deleteAll(){
    fetch(`${BASE_URL}/deleteAll`, { method: "DELETE" })
        .then(res => res.text())
        .then(msg => { alert(msg); fetchStudents(); });
}

// Display in table
function displayStudents(students){
    const tbody = document.querySelector("#studentTable tbody");
    tbody.innerHTML = "";

    students.forEach(s => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.course}</td>
            <td>${s.address}</td>
            <td>
                <button onclick='editStudent(${JSON.stringify(s)})'>Edit</button>
                <button onclick="updateCourse('${s.id}')">Update Course</button>
                <button onclick="deleteStudent('${s.id}')">Delete</button>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

// Pre-fill form for update
function editStudent(student){
    document.getElementById("studentId").value = student.id;
    document.getElementById("name").value = student.name;
    document.getElementById("age").value = student.age;
    document.getElementById("course").value = student.course;
    document.getElementById("address").value = student.address;
}

function resetForm(){
    document.getElementById("studentId").value = "";
    document.getElementById("studentForm").reset();
}
