export interface User {
  userId: number;
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  date: Date;
  cDate: Date;
  lDate: Date;
  notLocked: boolean;
  role: string;
  password:string;
}
