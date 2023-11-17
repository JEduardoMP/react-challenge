import React, { useState } from 'react';
import PeriodicTable from './components/periodicTable';
import FormComponent from './components/formComponent';
import './App.css';
import { matchNames } from './services/matchNames';

const App = () => {
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const [highlightedElements, setHighlightedElements] = useState<any[] | []>(
    [],
  );
  const [name, setName] = useState({
    firstName: '',
    lastName: '',
  });

  const highlightName = async (firstName: string, lastName: string) => {
    const BODY = {
      firstName,
      lastName,
    };
    const apiResponse = await matchNames(BODY);

    setHighlightedElements(apiResponse?.highlightedElements);
    setName(() => ({
      firstName: firstName.replace(apiResponse?.highlightedElements[0], ''),
      lastName: lastName.replace(apiResponse?.highlightedElements[1], ''),
    }));
  };

  return (
    <div>
      <div className="highlighted-elements">
        {highlightedElements.map((element, idx) => (
          <div key={element} className="highlighted-element">
            <PeriodicTable element={element} />
            {idx === 0 ? <h2>{name.firstName}</h2> : <h2>{name.lastName}</h2>}
          </div>
        ))}
      </div>
      <FormComponent highlightName={highlightName} />
    </div>
  );
};

export default App;
