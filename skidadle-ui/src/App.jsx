import { Routes, Route } from "react-router-dom";
import LandingPage from "./pages/landingPage/landingpage";
import MainBoard from "./pages/MainBoard/MainBoard";

function App() {
  return (
    <Routes>
      <Route path="/" element={<LandingPage />} />
      <Route path="/board" element={<MainBoard />} />
    </Routes>
  );
}

export default App;