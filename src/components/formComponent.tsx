/* eslint-disable jsx-a11y/label-has-associated-control */
import React, { FC, useState } from 'react';
import '../styles/formComponent.styles.css';

interface Props {
  highlightName: (firstName: string, lastName: string) => void;
}

const FormComponent: FC<Props> = ({ highlightName }) => {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    if (name === 'firstName') {
      setFirstName(value);
    } else {
      setLastName(value);
    }
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    highlightName(firstName, lastName);
  };

  return (
    <form onSubmit={handleSubmit} className="form-container">
      <div className="inputs-container">
        <label>
          First Name:
          <input
            type="text"
            name="firstName"
            value={firstName}
            onChange={handleInputChange}
          />
        </label>
        <label>
          Last Name:
          <input
            type="text"
            name="lastName"
            value={lastName}
            onChange={handleInputChange}
          />
        </label>
      </div>
      <button type="submit">Breakly</button>
    </form>
  );
};

export default FormComponent;
