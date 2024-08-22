<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Basic Responsive Webpage</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f0f0;
    }

    .container {
        max-width: 600px;
        margin: 20px auto;
        text-align: center;
    }

    .navButton {
        display: block;
        width: 100%;
        max-width: 200px;
        padding: 10px;
        margin: 10px auto;
        font-size: 18px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .navButton:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<div class="container">
    <button id="homeButton" class="navButton">Home</button>
    <button id="aboutButton" class="navButton">About</button>
    <button id="contactButton" class="navButton">Contact</button>
</div>

<script>
    // Add event listeners to the buttons
    document.getElementById('homeButton').addEventListener('click', function() {
        alert('Home button clicked!');
        // Replace with actual functionality for Home button
    });

    document.getElementById('aboutButton').addEventListener('click', function() {
        alert('About button clicked!');
        // Replace with actual functionality for About button
    });

    document.getElementById('contactButton').addEventListener('click', function() {
        alert('Contact button clicked!');
        // Replace with actual functionality for Contact button
    });
</script>

</body>
</html>
