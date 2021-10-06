import React from 'react';
import './App.css';

export const ToolAvailable = ({ toolId, toolName }) => {
  return (
    <li className="toolAvilable list-group-item">
      <div className='row'>
        <div className='col-10'><h5>{toolName}</h5></div>
        <div className='col-1'>
          <a className="btn btn-primary btn-sm" href="Jumbo action link" role="button">+</a></div>
      </div>
    </li>
  );
}

export const SideBar = () => {

  //crea la variable para almacenar las tools
  const [tools, setTools] = React.useState([]);

  // Obtiene las tools del api
  const obtenerTools = async () => {
    const data = await fetch('http://127.0.0.1:8080/availableTools');
    setTools(await data.json());
  }

  //actualiza las tools
  React.useEffect(() => {
    obtenerTools();
  }, [])

  //crea la lista de tools a nivel de List items html
  const toolsList = tools.map(tool =>
    <ToolAvailable toolID={tool.idTool} toolName={tool.toolName} />
  )

  //retorna el componente side bar
  return (
    <div className="card">
      <div className="card-body">
        <h4 className="card-title">Tools for rental</h4>
      </div>
      <ul className="list-group list-group-flush">
        {toolsList}
      </ul>
    </div>
  )
}

export const UserInfo = ({ userId, userName, urlImageUser }) => {
  return (
    <div id='userInfo' className='row'>
      <div className='col-2'>
        <div className="media">
          <a className=" align-self-center" href="#">
            <img height='100vh' src={urlImageUser} alt="" />
          </a>
        </div>
      </div>
      <div className='col-10'>
        <div className='row'>
          <div className='col-10 p-4'><h2>{userName}</h2></div>
          <div className='col-1 p-4'>
            <a className="btn btn-secondary btn-sm" href="Jumbo action link" role="button">Edit</a></div>
        </div>
      </div>
      <hr className="my-2" />
    </div>
  );
}

export const RentedTool = ({ toolId, toolName, deliveryDate }) => {
  return (
    <div id='toolRented' className='row'>
      <div className='col-2'>
        <div className="border border-primary rounded">
          <h3 className='text-center'>{toolName}</h3>
        </div>
      </div>
      <div className='col-10'>
        <div className='row'>
          <div className='col-10 text-secondary'><h5>delivery date: {deliveryDate}</h5></div>
          <div className='col-1'>
            <a className="btn btn-primary btn-sm" href="Jumbo action link" role="button">return</a></div>
        </div>
      </div>
      <hr className="my-2" />
    </div>
  );
}

export const RentedTools = ({userId}) => {

  const [rentedTools, setRentedTools] = React.useState([]);
  // Obtiene las tools del api
  const obtenerRentedTools = async () => {
    const data = await fetch(`http://127.0.0.1:8080/rentalsById?idUser=${userId}`);
    setRentedTools(await data.json());
  }

  //actualiza las tools
  React.useEffect(() => {
    obtenerRentedTools();
  }, [])

  //crea la lista de tools a nivel de List items html
  const rentedToolsList = rentedTools.map(rental =>
    <RentedTool toolId={rental.tool.idTool} toolName={rental.tool.toolName} deliveryDate='13 dias' />
  )

  return (
    <div id='rentedTools'>
      {rentedToolsList}
    </div>
  );
}

function App() {
  return (
    <div className='container'>
      <div id='toolbar' className='row'>
        <div className="p-5 jumbotron">
          <h1 className="display-3">ToolRental</h1>
          <hr className="my-2" />
        </div>
      </div>
      <div className='row'>
        <div id='sidebar' className='col-4'>
          <SideBar />
        </div>
        <div id='content' className='col-8'>
          <UserInfo userId='1' userName='Alejandro Rodriguez' urlImageUser='https://www.saccsa.com.mx/wp-content/uploads/2017/02/avatar-round-3.png' />
          <RentedTools userId='1'/>
        </div>
      </div>
    </div>
  );
}

export default App;