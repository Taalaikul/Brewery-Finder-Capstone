import React from 'react';


const Scroll= (props) => {
    return (
        <div style={{overflowX: 'scroll', border: '5px solid black', height: '400px'}}>
            {props.children}
        </div>
    )
}

export default Scroll;