import { LootItemToggle } from './lootItem';

export interface Build {
  id: number;
  name: string;
  items: LootItemToggle[];
}
