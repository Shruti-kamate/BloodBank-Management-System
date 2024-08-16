const express = require("express");
const nodemailer = require("nodemailer");
const bodyParser = require("body-parser");
const cors = require("cors");

const app = express();
const PORT = 5000;

// Middleware to parse JSON payloads
app.use(bodyParser.json());

// Cors middleware to handle CORS headers
app.use(cors());

// Nodemailer transporter setup
let transporter = nodemailer.createTransport({
  service: "gmail",
  auth: {
    user: "suyashsharma974@gmail.com", // Replace with your Gmail email address
    pass: "fmez bnin ylji rzbr", 
  },
});

// Endpoint to send email
app.post("/sendEmail", async (req, res) => {
  const { to, subject, text } = req.body;

  try {
    // Send mail with defined transport object
    let info = await transporter.sendMail({
      from: "attri1379@gmail.com", // Sender address (should be same as auth.user)
      to, // Dynamic recipient email address fetched from the frontend
      subject,
      text,
    });

    console.log("Email sent:", info.messageId);
    res.status(200).send("Email sent successfully.");
  } catch (error) {
    console.error("Error sending email:", error);
    res.status(500).send("Error sending email.");
  }
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
