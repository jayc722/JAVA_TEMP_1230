import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from './Main';
import Footer from './Footer';
import Header from './Header';
import PostList from './PostList';


function App() {
  return (
    <BrowserRouter>
      <Header/>
      <Routes>  
        <Route path="/" exact element = {<Main/>}/>
        <Route path='/post/list/:num' element={<PostList/>} />
      </Routes>
      <Footer/>

    </BrowserRouter>
  );
}

export default App;
